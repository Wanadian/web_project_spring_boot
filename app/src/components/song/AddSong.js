import './Song.css';
import Input from "../Input";
import {useEffect, useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

function AddSong() {
    const [song, setSong] = useState({title: '', artistId: 0, type: '', date: new Date, url: ''});
    const [artists, setArtists] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        async function fetchArtists() {
            const result = await axios.get(`http://localhost:8080/artists`);
            if (result.data) {
                setArtists(result.data)
                const newSong = {...song, artistId: result.data[0].id};
                setSong(newSong);
            }
        }

        fetchArtists();
    }, []);

    function handleChangeValue(property, value) {
        const newSong = {...song, [property]: value};
        setSong(newSong);
    }

    function handleSelectChange(event) {
        const newSong = {...song, artistId: event.target.value};
        setSong(newSong);
    }

    async function handleSubmit(event) {
        event.preventDefault();
        try {
            const result = await axios.post(`http://localhost:8080/songs/${song.artistId}`, song);
            navigate(`/songs/${result.data.id}`);
        } catch (error) {
            console.log('Error');
        }
    }

    return (
        <div>
            <Input property={'title'} type={'text'} value={song.title} placeholder={'Title'} handleChangeValue={handleChangeValue}/>
            <Input property={'type'} type={'text'} value={song.type} placeholder={'Type'} handleChangeValue={handleChangeValue}/>
            <Input property={'url'} type={'text'} value={song.url} placeholder={'URL'} handleChangeValue={handleChangeValue}/>
            <Input property={'date'} type={'date'} value={song.date} handleChangeValue={handleChangeValue}/>
            <select value={song.artistId} onChange={handleSelectChange}>
                {artists.map((artist) => <option key={artist.id} value={artist.id}>{artist.name}</option>)}
            </select>
            <button className={'Link'} onClick={handleSubmit}>Save</button>
        </div>
    )
}

export default AddSong;
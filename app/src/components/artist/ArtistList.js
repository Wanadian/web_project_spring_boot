import '../song/SongList.css'
import Artist from "./Artist";
import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from "axios";

function ArtistList() {
    const [artists, setArtists] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        async function fetchArtists() {
            const result = await axios.get(`http://localhost:8080/artists`);
            if (result.data) {
                setArtists(result.data)
            }
        }

        fetchArtists();
    }, []);

    async function handleClick(event) {
        event.preventDefault();
        navigate(`/artists/add`);
    }

    function deleteArtist(index){
        const newArtists = [...artists];
        newArtists.splice(index,1);
        setArtists(newArtists);
    }

    return (
        <div>
            <div className={"ArtistList"}>
                {artists.map((artist,index) =>
                    <Artist key={artist.id} index={index} artist={artist} deleteArtist={deleteArtist}/>
                )}
            </div>
            <div>
                <button className={'Link'} onClick={handleClick}>Add artist</button>
            </div>
        </div>
    )
}

export default ArtistList;
import Song from "./Song";
import './SongList.css'
import {useEffect, useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

function SongList() {
    const [songs, setSongs] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        async function fetchSongs() {
            const result = await axios.get(`http://localhost:8080/songs`);
            if (result.data) {
                setSongs(result.data)
            }
        }

        fetchSongs();
    }, []);

    function handleClick(event) {
        event.preventDefault();
        navigate(`/songs/add`);
    }

    return (
        <div>
            <div className={"SongList"}>
                {songs.map((song) =>
                    <Song key={song.id} song={song}/>
                )}
            </div>
            <button className={'Link'} onClick={handleClick}>Add song</button>
        </div>
    )
}

export default SongList;
import Song from "./Song";
import './SongList.css'
import {useEffect, useState} from "react";
import axios from "axios";

function SongList() {
    const [songs, setSongs] = useState([]);

    useEffect(() => {
        async function fetchSongs() {
            const result = await axios.get(`http://localhost:8080/songs`);
            if (result.data) {
                setSongs(result.data)
            }
        }

        fetchSongs();
    }, []);

    return (
        <div className={"SongList"}>
            {songs.map((song) =>
                <Song key={song.id} song={song}/>
            )}
        </div>
    )
}

export default SongList;
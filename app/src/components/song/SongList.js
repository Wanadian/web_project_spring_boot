import Song from "./Song";
import './SongList.css'
import {useEffect, useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {faPlus, faPlusCircle} from "@fortawesome/free-solid-svg-icons";

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

  function handleHomeClick(event) {
    event.preventDefault();
    navigate(`/`);
  }

  function handleAddClick(event) {
    event.preventDefault();
    navigate(`/songs/add`);
  }

  return (
    <>
      <div className={"SongList"}>
        {songs.map((song) =>
          <Song key={song.id} song={song}/>
        )}
      </div>
      <button className={'Link AddButton LeftOverlay'} onClick={handleAddClick}>
        <FontAwesomeIcon className={'AddButton'} icon={faPlus} size={'3x'}/>
      </button>
      <button className={'Link Button RightOverlay'} onClick={handleHomeClick}>Home</button>
    </>
  )
}

export default SongList;
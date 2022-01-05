import './Artist.css'
import axios from "axios";
import {useNavigate} from "react-router-dom";

function Artist({index, artist, deleteArtist}) {
  const navigate = useNavigate();

  async function handleDeleteClick(event) {
    event.preventDefault();
    try {
      await axios.delete(`http://localhost:8080/artists/${artist.id}`);
      deleteArtist(index);
    } catch (error) {
      console.log('Error');
    }
  }

  return (
    <>
      <div className={'Artist'}>
        {artist.name}
        <button className={'Link'} onClick={handleDeleteClick}>Delete artist</button>
      </div>
    </>
  )
}

export default Artist;
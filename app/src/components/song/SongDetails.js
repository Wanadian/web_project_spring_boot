import './SongDetails.css'
import {useNavigate, useParams} from 'react-router-dom';
import {useEffect, useState} from 'react';
import axios from 'axios';
import Moment from 'react-moment';
import ReactPlayer from 'react-player/youtube';

function SongDetails() {
    const [song, setSong] = useState(null);
    const {songId} = useParams();
    const navigate = useNavigate();

    useEffect(() => {
        async function fetchSong() {
            const result = await axios.get(`http://localhost:8080/songs/${songId}`);
            if (result.data) {
                setSong(result.data)
            }
        }

        fetchSong();
    }, [songId]);

    async function handleSubmit(event) {
        event.preventDefault();
        try {
            const result = await axios.delete(`http://localhost:8080/songs/${songId}`);
            navigate(`/songs`);
        } catch (error) {
            console.log('Error');
        }
    }

    return (
        <div className={'SongDetails'}>
            {song ?
                <div>
                    <div>
                        <ReactPlayer url={song.url} controls={true} light={true} volume={0.2} width={'40vw'} height={'50vh'}/>
                    </div>
                    <div className={'Title'}>
                        {song.title}
                    </div>
                    <div>
                        Artist
                    </div>
                    <div>
                        Type: {song.type}
                    </div>
                    <div>
                        Date: <Moment locale={'en'} date={song.date} format={'LL'}/>
                    </div>
                    <button className={'Link'} onClick={handleSubmit}>Delete song</button>
                </div>
                : null}
        </div>
    );
}

export default SongDetails;
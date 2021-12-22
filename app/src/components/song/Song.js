import './Song.css';
import ReactPlayer from 'react-player/youtube';

function Song({song}){
    return(
        <div className={'Song'}>
            <div>
                <ReactPlayer url={song.url} controls={true} light={true} volume={0.2} width={'30vw'}/>
            </div>
            <div className={'Title'}>
                {song.title}
            </div>
        </div>
    )
}

export default Song;
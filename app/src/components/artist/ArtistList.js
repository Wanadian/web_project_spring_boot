import '../song/SongList.css'
import Artist from "./Artist";

function ArtistList() {
    const artists = [
        {
            "id": 1,
            "name": "Ariana Grande",
        },
        {
            "id": 2,
            "name": "Enemy",
        }
    ]
    return (
        <div className={"ArtistList"}>
            {artists.map((artist) =>
                <Artist key={artist.id} artist={artist}/>
            )}
        </div>
    )
}

export default ArtistList;
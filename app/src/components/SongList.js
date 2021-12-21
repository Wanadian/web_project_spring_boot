import Song from "./Song";
import './SongList.css'

function SongList() {
    const songs = [
        {
            "id": 51,
            "title": "7 rings",
            "date": "2019-04-23T18:25:43.511+00:00",
            "type": "pop",
            "url": "https://www.youtube.com/watch?v=QYh6mYIJG2Y"
        },
        {
            "id": 52,
            "title": "Enemy",
            "date": "2019-04-23T18:25:43.511+00:00",
            "type": "pop",
            "url": "https://www.youtube.com/watch?v=F5tSoaJ93ac"
        },
        {
            "id": 52,
            "title": "Enemy",
            "date": "2019-04-23T18:25:43.511+00:00",
            "type": "pop",
            "url": "https://www.youtube.com/watch?v=F5tSoaJ93ac"
        },
        {
            "id": 52,
            "title": "Enemy",
            "date": "2019-04-23T18:25:43.511+00:00",
            "type": "pop",
            "url": "https://www.youtube.com/watch?v=F5tSoaJ93ac"
        },
        {
            "id": 52,
            "title": "Enemy",
            "date": "2019-04-23T18:25:43.511+00:00",
            "type": "pop",
            "url": "https://www.youtube.com/watch?v=F5tSoaJ93ac"
        },
        {
            "id": 52,
            "title": "Enemy",
            "date": "2019-04-23T18:25:43.511+00:00",
            "type": "pop",
            "url": "https://www.youtube.com/watch?v=F5tSoaJ93ac"
        },
        {
            "id": 52,
            "title": "Enemy",
            "date": "2019-04-23T18:25:43.511+00:00",
            "type": "pop",
            "url": "https://www.youtube.com/watch?v=F5tSoaJ93ac"
        },
        {
            "id": 52,
            "title": "Enemy",
            "date": "2019-04-23T18:25:43.511+00:00",
            "type": "pop",
            "url": "https://www.youtube.com/watch?v=F5tSoaJ93ac"
        },
        {
            "id": 52,
            "title": "Enemy",
            "date": "2019-04-23T18:25:43.511+00:00",
            "type": "pop",
            "url": "https://www.youtube.com/watch?v=F5tSoaJ93ac"
        },
        {
            "id": 52,
            "title": "Enemy",
            "date": "2019-04-23T18:25:43.511+00:00",
            "type": "pop",
            "url": "https://www.youtube.com/watch?v=F5tSoaJ93ac"
        },
        {
            "id": 52,
            "title": "Enemy",
            "date": "2019-04-23T18:25:43.511+00:00",
            "type": "pop",
            "url": "https://www.youtube.com/watch?v=F5tSoaJ93ac"
        },
        {
            "id": 52,
            "title": "Enemy",
            "date": "2019-04-23T18:25:43.511+00:00",
            "type": "pop",
            "url": "https://www.youtube.com/watch?v=F5tSoaJ93ac"
        },
        {
            "id": 52,
            "title": "Enemy",
            "date": "2019-04-23T18:25:43.511+00:00",
            "type": "pop",
            "url": "https://www.youtube.com/watch?v=F5tSoaJ93ac"
        }
    ]
    return (
        <div className={"SongList"}>
            {songs.map((song) =>
                <Song key={song.id} song={song}/>
            )}
        </div>
    )
}

export default SongList;
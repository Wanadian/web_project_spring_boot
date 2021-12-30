import './App.css';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Welcome from "./components/Welcome";
import SongList from "./components/song/song/SongList";
import SongDetails from "./components/song/song/SongDetails";
import ArtistList from "./components/song/artist/ArtistList";

function App() {
    return (
        <div className={'App'}>
            <Router>
                <Routes>
                    <Route exact path={''} element={<Welcome/>}/>
                    <Route exact path={'/songs'} element={<SongList/>}/>
                    <Route exact path={'/songs/:songId'} element={<SongDetails/>}/>
                    <Route exact path={'/artists'} element={<ArtistList/>}/>
                </Routes>
            </Router>
        </div>
    );
}

export default App;

import './App.css';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Welcome from "./components/Welcome";
import SongList from "./components/song/SongList";
import SongDetails from "./components/song/SongDetails";

function App() {
    return (
        <div className={'App'}>
            <Router>
                <Routes>
                    <Route exact path={''} element={<Welcome/>}/>
                    <Route exact path={'/songs'} element={<SongList/>}/>
                    <Route exact path={'/songs/:songId'} element={<SongDetails/>}/>
                </Routes>
            </Router>
        </div>
    )
        ;
}

export default App;

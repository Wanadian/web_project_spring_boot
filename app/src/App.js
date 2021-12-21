import './App.css';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Welcome from "./components/Welcome";
import SongList from "./components/SongList";

function App() {
    return (
        <div className={'App'}>
            <Router>
                <Routes>
                    <Route exact path={''} element={<Welcome/>}/>
                    <Route exact path={'/songs'} element={<SongList/>}/>
                </Routes>
            </Router>
        </div>
    )
        ;
}

export default App;

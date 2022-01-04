import Input from "../Input";
import {useEffect, useState} from "react";
import axios from "axios";
import {useNavigate} from "react-router-dom";

function AddArtist() {
    const [artist, setArtist] = useState({name: ''});
    const navigate = useNavigate();

    function handleChangeValue(property, value) {
        const newArtist = {...artist, [property]: value};
        setArtist(newArtist);
    }

    function handleHomeClick(event) {
        event.preventDefault();
        navigate(`/`);
    }

    function handleBackClick(event) {
        event.preventDefault();
        navigate(`/artists`);
    }

    async function handleSubmit(event) {
        event.preventDefault();
        try {
            await axios.post(`http://localhost:8080/artists`, artist);
            navigate(`/artists`);
        } catch (error) {
            console.log('Error');
        }
    }

    return (
        <div>
            <Input property={'name'} type={'text'} value={artist.name} placeholder={'Name'} handleChangeValue={handleChangeValue}/>
            <button className={'Link'} onClick={handleSubmit}>Save</button>
            <div className={'Overlay'}>
                <button className={'Link Button'} onClick={handleHomeClick}>Home</button>
                <button className={'Link Button'} onClick={handleBackClick}>Back</button>
            </div>
        </div>
    )
}

export default AddArtist;
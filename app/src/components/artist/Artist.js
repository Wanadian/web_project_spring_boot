import './Artist.css'

function Artist({artist}){
    return(
        <div className={'Artist'}>
            {artist.name}
        </div>
    )
}

export default Artist;
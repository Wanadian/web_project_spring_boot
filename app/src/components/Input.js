function Input(props){
    function handleChangeValue(event){
        props.handleChangeValue(props.property, event.target.value)
    }
    return(
        <input type={props.type} value={props.value} placeholder={props.placeholder} onChange={handleChangeValue}/>
    )
}

export default Input;
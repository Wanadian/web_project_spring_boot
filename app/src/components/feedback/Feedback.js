import './Feedback.css'
function Feedback({feedback}) {

  return (
    <div className={'Comment'}>
      <div>
        Mark : {feedback.mark}/5
      </div>
      <div>
        {feedback.comment}
      </div>
    </div>
  )
}

export default Feedback;
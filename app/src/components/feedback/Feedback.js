function Feedback({feedback}) {

  return (
    <div>
      <div>
        {feedback.mark}
      </div>
      <div>
        {feedback.comment}
      </div>
    </div>
  )
}

export default Feedback;
const defaultState = {
  tasks: [{
    id: 1,
    content: 'test',
    completed: false
  }]
}

export default function (state = defaultState, action) {
  switch (action.type) {
    case 'TASK:ADD':
      return {
        ...state,
        tasks: [...state.tasks, action.payload.newTask]
      }


    case 'TASK:EDIT':
      return {
        ...state,
        tasks: state.tasks.map(task => {
          return (task.id === action.payload.id)
            ? { ...task, content: action.payload.content }
            : task
        })
      }

    case 'TASK:TOOGLE':
      return {
        ...state,
        tasks: state.tasks.map(task => {
          return (task.id === action.payload.id)
            ? { ...task, completed: !task.completed }
            : task
        })
      }

    case 'TASK:DELETE':
      return {
        ...state,
        tasks: state.tasks.filter(task => task.id !== action.payload.id)
      }

    default:
      return state;
  }
}

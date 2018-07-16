export const addTask = (content) => {
  return {
    type: 'TASK:ADD',
    payload: {
      newTask: {
        content,
        id: new Date().getTime(),
        completed: false
      }
    }
  }
}

export const editTask = (id, content) => {
  return {
    type: 'TASK:EDIT',
    payload: { id, content }
  }
}

export const toogleTask = (id) => {
  return {
    type: 'TASK:TOOGLE',
    payload: { id }
  }
}

export const deleteTask = (id) => {
  return {
    type: 'TASK:DELETE',
    payload: { id }
  }
}

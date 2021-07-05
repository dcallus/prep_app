const baseURL = 'http://192.168.1.2:8080/'

const MealAppService = {

  getFoodItem() {
    return fetch(baseURL + "food/")
    .then(res => res.json())
  },

  postFoodItem(payload) {
    return fetch(baseURL + "food/", {
      method: 'POST',
      body: JSON.stringify(payload),
      headers: { 'Content-Type': 'application/json'}
    })
    .then(res => res.json())
  },

  deleteFoodItem(id) {
    return fetch(baseURL + "food/" + id, {
      method: 'DELETE'
    })
  }
}

export default MealAppService;
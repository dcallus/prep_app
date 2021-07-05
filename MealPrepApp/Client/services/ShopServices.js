const baseURL = 'http://192.168.1.2:8080/'

const ShopServices = {

  getShop() {
    return fetch(baseURL + "shop/")
    .then(res => res.json())
  },

  getShopMenu(id) {
    return fetch(baseURL + "shop/" + id + "/menu")
    .then(res => res.json())
  },

  postShop(payload) {
    return fetch(baseURL + "shop/", {
      method: 'POST',
      body: JSON.stringify(payload),
      headers: { 'Content-Type': 'application/json'}
    })
    .then(res => res.json())
  },

  deleteShop(id) {
    return fetch(baseURL + "shop/" + id, {
      method: 'DELETE'
    })
  }
}

export default ShopServices;
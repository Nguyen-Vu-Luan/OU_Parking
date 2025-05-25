import axios from "axios"

const BASE_URL = 'http://localhost:8080/OU_Parking/api'

export const endpoints = {
     'ParkingLots': '/parkinglots',
     'ParkingSlots': '/parkingslots'
}

export default axios.create({
    baseURL: BASE_URL
});
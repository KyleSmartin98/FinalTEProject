import axios from 'axios';

export default {
//Doctor call
  listAppointments() {
    return axios.get('/appointments'); 
  },
  getAppointment(id) {
      return axios.get('/appointments/${id}', id)
  },
  addAppointment(){
      return axios.post('/appointments')
  }, 
  updateAppointment(id){
      return axios.put('/appointments/${id}', id)
  }, 
  deleteAppointment(id){
      return axios.delete('/appointments/${id}', id)
  }, 
  getAppointmentByDoctorId(id){
    return axios.get('/appointments/doctors/${id}', id)
  },
  getAppointmentByPatientId(id){
    return axios.get('/appointments/patients/${id}', id)
  }

}
<template>
  <div id="register" class="text-center register-container">
    <div class="register-body elevated-box-body">
        <form class="form-register" @submit.prevent="register">
          <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
          <div class="alert alert-danger" role="alert" v-if="registrationErrors">
            {{ registrationErrorMsg }}
          </div>
          <label for="username" class="sr-only">Username</label>
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
          <label for="password" class="sr-only">Password</label>
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
          <input
            type="password"
            id="confirmPassword"
            class="form-control"
            placeholder="Confirm Password"
            v-model="user.confirmPassword"
            required
          />
        <div class="account-buttons"><router-link style="margin-right:20px" :to="{ name: 'login' }">Have an account?</router-link>
          <v-btn class="btn btn-lg btn-primary btn-block" type="submit">
            Create Account
          </v-btn></div>
        </form>
     </div><!--reg-end-->   
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              })
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    }
  },
};
</script>

<style>
   .register-container{
    margin-top: 184px;
    align-content: center;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: flex-end space-between;
    min-height: calc(100vh - 100px);
    }
    .account-buttons{
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center space-between;
    }

</style>

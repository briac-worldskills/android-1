<template>
  <div class="modal">
    <h1>Merci de vous connecter</h1>
    <br>
    <p>Votre email :</p>
    <input v-model="email" placeholder="email@domaine.com" class="email-field">
    <br>
    <p>Votre mot de passe :</p>
    <input v-model="password" placeholder="mot de passe" class="password-field">
    <br>
    <button class="btn-login" v-on:click="loginMethod()">Connexion</button>
  </div>
</template>

<script>
export default {
  name: 'LoginComponent',
  props: {
    msg: String,
  },
  data: function () {
    return {
      email: "",
      password: "",
    }
  },
  methods: {
    loginMethod: function() {
      //faire l'appel API ici avec le get login et mot de passe

      //emit au parent le login = true
      this.$emit('onLogin', true);
    }
  },
  mounted: function() {
      
  }
}
</script>

<style scoped>
.btn-login {
  border-radius: 5px;
  width: 45%;
  height: 7%;
  font-size: 15px;
  font-weight: bold;
  background-color: lightblue;
  margin-top: 70px;
}
.modal {
  height: 500px;
  width: 500px;
  background-color: lightgray;
  position: fixed;
  left: 0;
  z-index: 99;
  margin: auto;
  border-radius: 25px;
  right: 0;
  top: 0;
  bottom: 0;
}
.email-field {
  margin-bottom: 30px;
  width: 50%;
  height: 5%;
  border-radius: 5px;
}
.password-field {
  width: 50%;
  height: 5%;
  border-radius: 5px;
}
</style>

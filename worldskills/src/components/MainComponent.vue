<template>
  <div class="hello">
    <div class="header">
      <div>
        <p class="logo">LOGO</p>
        <p class="profil-link"><a href="#">Page profil</a></p>
      </div>
    </div>
    <button v-on:click="getUser()">Get User</button>
    <div v-if="showUser">

    <table class="table">
      <thead>
        <tr>
          <th>ID</th>
          <th>Email</th>
          <th>Password</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="user in users" :key="user.id">
          <th>{{user.id}}</th>
          <th>{{user.email}}</th>
          <th>{{user.password}}</th>
        </tr>
      </tbody>
    </table>


    <ul>
      <li v-for="user in users" :key="user.id">{{user.email}} - {{user.password}}</li>
    </ul>
    </div>

    <br>
    <input v-model='email'>
    <br>
    <input v-model='password'>
    <br>  
    <button v-on:click="saveUser()">Enregistrement</button>


    <br>
    <br>
    <br>
    <br>
    <input v-model="id">
    <button v-on:click="deleteUser()">Delete</button>
    <br>
    <br>

    <select v-model="selected">
      <option v-for="user in users" :key="user.id" >{{user.email}}</option>
    </select>
    {{this.selected}}
    <LoginComponent @onLogin="loginMethod" v-if='login === false'/>
  </div>
</template>

<script>
import LoginComponent from './Login.vue'

export default {
  name: 'MainComponent',
  props: {
    msg: String,
  },
  components: {
    LoginComponent
  },
  data: function () {
    return {
      showUser: false,
      users: "oui",
      opts: "{\"email\": \"bibi-vue@gmail.com\",\"password\": \"bibi\"}",
      response: "",
      email: "",
      password: "",
      login: false,
      selected: "",
      id: ""
    }
  },
  methods: {
    getUser: async function () {
      //Get une data
      const response = await fetch('http://localhost:8080/users');
      const json = await response.json();
      this.users = json;
      this.showUser = true
    },

    loginMethod: function (e) {
      this.login = e;
    },

    saveUser: async function() {
      //Save user
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Cookie", "COOKIE_SUPPORT=true; GUEST_LANGUAGE_ID=fr_FR");

      var raw = JSON.stringify({"id":0,"email":this.email,"password":this.password});

      var requestOptions = {
        method: 'POST',
        headers: myHeaders,
        body: raw,
        redirect: 'follow'
      };

      fetch("http://localhost:8080/users", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
    },

    deleteUser: async function() {
      //Delete un user
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Cookie", "COOKIE_SUPPORT=true; GUEST_LANGUAGE_ID=fr_FR");

      var requestOptions = {
        method: 'DELETE',
        headers: myHeaders,
        redirect: 'follow'
      };

      fetch("http://localhost:8080/users?id=" + this.id, requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
    }
  },
  mounted: function() {
      var myHeaders = new Headers();
      myHeaders.append("Content-Type", "application/json");
      myHeaders.append("Cookie", "COOKIE_SUPPORT=true; GUEST_LANGUAGE_ID=fr_FR");

      var requestOptions = {
        method: 'GET',
        headers: myHeaders,
        redirect: 'follow'
      };

      fetch("http://localhost:8080/users?id=7", requestOptions)
        .then(response => response.text())
        .then(result => {
          this.email = JSON.parse(result)[0].email;
          this.password = JSON.parse(result)[0].password;
        })
  }
}
</script>

<style scoped>
.header{
  background: red;
  width: 100%;
  height: 75px;
  top: 0;
  position: absolute;
  right: 0;
}
.profil-link {
  right: 0px;
  position: fixed;
}
.logo {
  left: 0px;
  position: fixed;
}
</style>

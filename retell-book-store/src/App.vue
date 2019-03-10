<template>
  <div id="app">
    <!--<img alt="Vue logo" src="./assets/logo.png">-->
    <!--<HelloWorld msg="Welcome to Your Vue.js App"/>-->
    <div class="navigation">
      <input type="checkbox" class="navigation__checkbox" id="nav-toggle">

      <label for="nav-toggle" class="navigation__button">
        <span class="navigation__icon">
          &nbsp;
        </span>
      </label>

      <div class="navigation__background">&nbsp;</div>

      <nav class="navigation__nav">
        <ul class="navigation__list">
          <li class="navigation__item"><a href="#" class="navigation__link"><span>01</span>About Natours</a></li>
          <li class="navigation__item"><a href="#" class="navigation__link"><span>02</span>Your benifits</a></li>
          <li class="navigation__item"><a href="#" class="navigation__link"><span>03</span>Popular tours</a></li>
          <li class="navigation__item"><a href="#" class="navigation__link"><span>04</span>Stories</a></li>
          <li class="navigation__item"><a href="#" class="navigation__link"><span>05</span>Book now</a></li>
        </ul>
      </nav>
    </div>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'app',
  components: {
    HelloWorld
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

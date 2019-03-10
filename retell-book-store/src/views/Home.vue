<template>
  <div class="home">
    <navigator></navigator>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import Navigator from'@/components/Navigator.vue'

export default {
  name: 'home',
  components: {
    HelloWorld,
      Navigator
  }
}
</script>

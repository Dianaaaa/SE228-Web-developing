<template>
  <div class="home">
    <navigator></navigator>
    <Header></Header>
    <BookCategory></BookCategory>
    <Footer></Footer>
  </div>
</template>

<script>
// @ is an alias to /src
import Navigator from'@/components/Navigator.vue'
import Header from '@/components/Header.vue'
import BookCategory from '@/components/BookCategory.vue'
import Footer from '@/components/Footer.vue'

export default {
  name: 'home',
  components: {
      Navigator,
      Header,
      BookCategory,
      Footer
  }
}
</script>

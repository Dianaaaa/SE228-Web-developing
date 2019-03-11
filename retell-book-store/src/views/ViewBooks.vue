<template>
  <div class="viewbooks">
    <Navigator></Navigator>
    <SectionBlock msg="书架"></SectionBlock>
    <BookView></BookView>
    <Footer></Footer>
  </div>

</template>

<script>
  import BookView from "@/components/BookView.vue"
  import Navigator from "@/components/Navigator.vue"
  import SectionBlock from "@/components/SectionBlock.vue"

  import Footer from "@/components/Footer.vue"

  export default {
      name: 'viewbooks',
      components: {
          BookView,
          Navigator,
          SectionBlock,
          Footer
      }
  }
</script>

<template>
  <div class="viewbooks">
    <BookView></BookView>
  </div>

</template>

<script>
  import BookView from "@/components/BookView.vue"

  export default {
      name: 'viewbooks',
      components: {
          BookView
      }
  }
</script>

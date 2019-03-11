<template>
    <div id="bookdetail">
        <Navigator></Navigator>
        <Detail></Detail>
        <Footer></Footer>
    </div>
</template>

<script>
    // @ is an alias to /src
    import Navigator from'@/components/Navigator.vue'
    import Footer from '@/components/Footer.vue'
    import Detail from '@/components/Detail.vue'

    export default {
        name: 'home',
        components: {
            Navigator,
            Footer,
            Detail        }
    }
</script>
<template>
    <div id="signup">
        <Navigator></Navigator>
        <Register></Register>
        <Footer></Footer>
    </div>
</template>

<script>
    import Navigator from'@/components/Navigator.vue'
    import Footer from '@/components/Footer.vue'
    import Register from '@/components/Register.vue'

    export default {
        name: 'home',
        components: {
            Navigator,
            Footer,
            Register
        }
    }
</script>
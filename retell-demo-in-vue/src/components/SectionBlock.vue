<template>
    <div class="sectionblock">
        <div class="sectionblock__text heading-primary">
            <h1 class="heading-primary--sub">{{ msg }}</h1>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'SectionBlock',
        props: {
            msg: String
        }
    }
</script>
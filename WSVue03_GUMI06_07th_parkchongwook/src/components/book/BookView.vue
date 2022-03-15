<template>
    <view-detail/>
</template>
<script>
import ViewDetail from "@/components/book/include/ViewDetail.vue"
export default({
    name: 'book-view',
    components:{
        ViewDetail
    },    
    created() {        
        this.$store.dispatch("getBook", `/${this.$route.params.isbn}`); 
    },

})
</script>

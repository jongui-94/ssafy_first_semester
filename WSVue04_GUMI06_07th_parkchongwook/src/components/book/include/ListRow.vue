<template>
    <tr>
        <td>{{ no }}</td>
        <td>{{ isbn }}</td>
        <td><router-link :to="{name: 'book-view', params: {isbn: isbn}}">
        {{ title }}
        </router-link></td>
        <td>{{ author }}</td>
        <td>{{ price | priceFilter }}</td>
    </tr>
</template>

<script>

export default ({
    name: "list-row",
    props: {
        no:{type : String},
        isbn:{type : String},
        title:{type : String},
        author:{type : String},
        price:{type : Number}
    },
    methods: {
        movePage() {
            this.$router.push({name : 'book-create'});
        }
    },
    filters: {
        priceFilter: function(value){
            if (!value) return value;
            return value.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        },
    }
})
</script>

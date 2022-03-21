<template>
  <div>
    <!-- <b-list-group>
      <b-list-group-item v-for="(item, idx) in products" :key="idx">
        <span> {{ item.name }}</span>
        <span> {{ item.type }}</span>
        <span> {{ item.price }}</span>
        <img :src="require('@/assets/menu/' + item.img)">
      </b-list-group-item>
    </b-list-group> -->

    <b-row>
      <b-col cols="3" v-for="(item, idx) in products" :key="idx">
        <b-card :title="item.name" :img-src="require('@/assets/menu/' + item.img)">
          <b-card-text>{{ item.price }} 원</b-card-text>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  name: 'product-list-view',
  created() {
    this.$store.dispatch('selectProducts');
  },
  computed: {
    products() {
      return this.$store.getters.getProducts;
    }
  }
}
</script>
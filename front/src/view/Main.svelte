<script>
  import Header from '@/view/header/Header.svelte';
  import { rxios } from '@/common/rxios.js';
  import { categoryQuery } from '@/query/category-query.js';

  rxios
    .post(categoryQuery.categories())
    .subscribe(response => console.log(response));
</script>

<div class="container">
  <Header />
</div>

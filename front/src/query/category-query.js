class CategoryQuery {
  categories() {
    return `{
      categories {
          categoryId,
          name,
          order
      }
    }`;
  }
  createCategory({ name, order }) {
    return `
      mutation{
        createCategory(category: {name:"${name}", order:${order}}) {
          categoryId,
          name,
          order
        }
      }
    `;
  }
}

export const categoryQuery = new CategoryQuery();

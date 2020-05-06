import { assignIn } from 'lodash-es';

class Category {
  constructor(category) {
    assignIn(this, category);
  }
}

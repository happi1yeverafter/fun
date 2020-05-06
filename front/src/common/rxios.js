import Axios from 'axios';
import { defer } from 'rxjs';
import { map, tap } from 'rxjs/operators';

export const rxios = {
  post(body) {
    return defer(() =>
      Axios.post('http://localhost:8080/graphql', { query: body })
    ).pipe(
      map((response) => response.data),
      tap((data) => throwIfError(data))
    );
  },
};

function throwIfError(data) {
  if (data.errors) {
    throw data.errors[0].message;
  }
}

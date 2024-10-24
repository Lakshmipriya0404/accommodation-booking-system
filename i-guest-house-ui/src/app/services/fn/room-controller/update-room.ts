/* tslint:disable */
/* eslint-disable */
/* Code generated by ng-openapi-gen DO NOT EDIT. */

import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Room } from '../../models/room';

export interface UpdateRoom$Params {
  id: number;
      body: Room
}

export function updateRoom(http: HttpClient, rootUrl: string, params: UpdateRoom$Params, context?: HttpContext): Observable<StrictHttpResponse<Room>> {
  const rb = new RequestBuilder(rootUrl, updateRoom.PATH, 'put');
  if (params) {
    rb.path('id', params.id, {});
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Room>;
    })
  );
}

updateRoom.PATH = '/rooms/{id}';

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Product } from '../model/product';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  apiUrl=environment.apiUrl+"product";
  constructor(private http:HttpClient) { }
  getProducts():Observable<Product[]>{
    return this.http.get<Product[]>(this.apiUrl);
  }
  getProduct(product:Product):Observable<Product>{
    return this.http.get<Product>(this.apiUrl+"/"+product.id);
  }
  updateProduct(product:Product):Observable<Product>{
    return this.http.put<Product>(this.apiUrl+"/",product);
  }
  addProduct(product:Product):Observable<Product>{
    return this.http.post<Product>(this.apiUrl+"/",product);
  }
  deleteProduct(id?:number):Observable<Product>{
    return this.http.delete<Product>(this.apiUrl+"/"+id);
  }

}

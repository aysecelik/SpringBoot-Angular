import { Component, OnInit } from '@angular/core';
import { ConfirmationService, MessageService } from 'primeng/api';
import {Product} from '../model/product'
import { ProductService } from '../service/product.service';
@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products:Product[];
  product:Product;
  productDialogvisible:boolean;
  constructor(private productService:ProductService,
    private confirmationService:ConfirmationService,
    private messageService:MessageService) {
    this.products =[];
    this.product={};
    this.productDialogvisible=false;
   }
getProducts(){
  this.productService.getProducts().subscribe(data=>this.products=data);
}
  ngOnInit(): void {
    this.getProducts();
  }
  hideDialog(){
    this.productDialogvisible=false;
  }
  sopenFileForm(p:Product){
    this.product={...p};
    this.productDialogvisible=true;
  }
  openFileForm(p:Product){
    this.product={};
    this.productDialogvisible=true;
  }

  deleteProduct(product:Product){
    this.confirmationService.confirm({
      message: 'Are you sure you want to delete the selected products?',
      header: 'Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.productService.deleteProduct(product.id).subscribe(data=>this.getProducts())
        this.messageService.add({severity:'success', summary: 'Successful', detail: 'Products Deleted', life: 3000});
      }
  });
  }
  createorupdate(product:Product){
    if(this.product.id && this.product.id>0){
this.productService.updateProduct(product).subscribe(data=>this.getProducts());
this.messageService.add({severity:'success', summary: 'Successful', detail: 'Products Updated', life: 3000});


    }
    else{
      this.productService.addProduct(product).subscribe(data=>this.getProducts());
      this.messageService.add({severity:'success', summary: 'Successful', detail: 'Products Added', life: 3000});
    }
  }
 

}

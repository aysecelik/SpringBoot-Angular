import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {TableModule} from 'primeng/table';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './product-list/product-list.component';

import { HttpClientModule,HttpClient,HttpHeaders,HttpHandler } from '@angular/common/http';
import { ProductService } from './service/product.service';
import { ConfirmationService } from 'primeng/api';
import { MessageService } from 'primeng/api';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import {FormsModule} from '@angular/forms';
import {ToastModule} from 'primeng/toast';
import {DialogModule} from 'primeng/dialog';
import {ButtonModule} from 'primeng/button';
import {InputTextModule} from 'primeng/inputtext';
@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent
  ],
  imports: [
    ConfirmDialogModule,
    FormsModule,
    ToastModule,
    DialogModule,
    ButtonModule,
    InputTextModule,

    BrowserModule,
    AppRoutingModule,
    TableModule,
    HttpClientModule,
  ],
  providers: [ProductService,HttpClient,MessageService,ConfirmationService],
  bootstrap: [ProductListComponent]
})
export class AppModule { }

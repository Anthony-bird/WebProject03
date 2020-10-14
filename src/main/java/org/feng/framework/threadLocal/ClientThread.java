package org.feng.framework.threadLocal;

public class ClientThread extends Thread {
    private Sequence sequence;
    private ProductService productService;

    public ClientThread(Sequence sequence) {
        this.sequence = sequence;
    }

    public ClientThread(ProductService productService) {
        this.productService = productService;
    }
/*
    @Override
    public void run() {
        for (int i=0;i< 3;i++) {
            System.out.println(Thread.currentThread().getName() + "=>>" + sequence.getNumber());
        }
    }*/

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        productService.updateProductPrice(1,3000);
    }
}

package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {


    private List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
        contas = new ArrayList<Conta>();
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return this.pesquisaDeConta(conta).saldo;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public void adicionarConta(String numero){
        Conta conta = new Conta(numero);
        contas.add(conta);
    }

    @Override
    public Conta pesquisaDeConta(String numero){
        for(Conta conta : this.contas) {
            if (conta.getNumero().equals(numero))
                System.out.println("ACHEIIIIIIIIIIIIIIIIIIIIIII");
                return conta;
        }
        return null;
    }

    @Override
    public Conta removeConta(String numero){
        Conta contaDeletada = null;
        for(Conta conta : contas){
            if (conta.getNumero().equals(numero))
                contaDeletada = conta;
                break;
        }
        return contaDeletada;
    }

}

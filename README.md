# SearchEngine

Busca por uma sentença em todos os arquivos em uma determinada pasta e exibe quantos e quais arquivos possuem a palavra-chave. 

## Instalação

O projeto precisa ser clonado:

```sh
$ git clone https://github.com/angelobms/SearchEngine.git
$ cd SearchEngine
```

Após clonar o projeto, abra ele na IDE IntelliJ IDEA e faça o BUILD. Depois execute o seguinte comando para instalação:

```sh
jar cvfm search.jar MANIFEST.MF -C out/production/SearchEngine/ . jar cvfm search.jar MANIFEST.MF -C out/production/SearchEngine/ . 
```

## Execução

Copie o executavel .jar para a pasta ao qual deseja fazer a pesquise e execute-o com o comando abaixo:

```sh
$ java -jar search.jar walt disney
```

Onde "walt disney" foi a sentença utilizada para a pesquisa como exemplo.

# INGEGNERIA/PROGETTAZIONE DEL SOFTWARE

## Progetto (turno P)

Obiettivo del progetto è la realizzazione di un piccolo gioco chiamato **laser game**.

Il progetto si svolge in gruppi di **sei studenti**. Il risultato definitivo del lavoro va consegnato entro Venerdì 17 Giugno alle ore 12:30.

Ogni gruppo di studenti sceglie il **leader** che procede a [formare il
gruppo](https://sweng.di.unimi.it/gruppo) dopodiché il gruppo *clona* il **fork** di questo repository sulla propria macchina usando il comando `git clone` riportato alla
creazione del gruppo *(in nessun caso deve essere clonato questo repository,
ma solo il fork creato nell'account del leader)*.

Il progetto avrà durata una settimana e occuperà gli ultimi **due laboratori** nel seguente modo:

* **Venerdì 10/6**: il gruppo prende visione delle [linee guida](https://bitbucket.org/softwareengineeringunimi/progetto_2016-p/wiki/Requisiti%20utente) del *laser game* che rappresentano un estratto dei requisiti utente. Dopodiché seguendo la metodologia del [planning game](https://bitbucket.org/softwareengineeringunimi/progetto_2016-p/wiki/Planning%20game) formula una **proposta delle funzionalità** che intende realizzare e fornisce una descrizione delle medesime, nonché una **stima dei tempi** di sviluppo che deve dare luogo alla compilazione del [Planning](https://bitbucket.org/softwareengineeringunimi/progetto_2016-p/wiki/Planning) presente nel Wiki.
* **Venerdì 17/6**: il gruppo dimostra le funzionalità del programma sviluppato attraverso una presentazione in aula di **15 minuti massimo**, seguiti da **5 minuti** di eventuali domande da parte dei docenti. Durante la presentazione, il gruppo illustra inoltre brevemente il *planning* e il lavoro svolto discutendo anche le scelte progettuali adottate, così come riportate nella pagina [Scelte progettuali](https://bitbucket.org/softwareengineeringunimi/progetto_2016-p/wiki/Scelte%20progettuali) del Wiki.


## Processo 

Il gruppo implementa secondo la metodologia **TDD** le funzionalità concordate durante il *planning*; in maggior dettaglio, il gruppo viene diviso in sottogruppi (a discrezione del team di sviluppo) ed ogni sottogruppo sceglie una funzionalità non ancora sviluppata (presente nell'*issue tracker* come descritto in seguito) e ripete i passi seguenti fino al termine delle funzionalità proposte:

* sceglie un **breve** passo di sviluppo,
* scrive il codice di un *test* per il passo scelto, verificando che **il
  codice compili correttamente**, ma l'**esecuzione del test fallisca**;
  se lo ritiene utile (ossia *facoltativamente*, ma non prima di trovarsi
  in queste condizioni) effettua un *commit* (usando `git add` e `git commit`)
  iniziando il messaggio di commit con la stringa `ROSSO:`,
* aggiunge l'implementazione necessaria a realizzare il passo relativo al test
  introdotto, in modo che **il test esegua con successo**; a questo punto *deve*
  effettuare un *commit* (usando `git add` e `git commit`) iniziando il messaggio di
  commit con la stringa `VERDE:`,
* procede, se necessario, al **refactoring** del codice, accertandosi che le modifiche
  non comportino il fallimento di alcun test; solo in questo caso fa seguire ad ogni
  passo di questo tipo un *commit* (usando `git add` e `git commit`) iniziando il
  messaggio di commit con la stringa `REFACTORING:`

La sincronizzazione avviene attraverso brevi riunioni per accordarsi sul lavoro da svolgere e attraverso il *repository remoto* (usando opportunamente i comandi `git push` e `git pull`).
Si consiglia di creare un nuovo ramo (*branch*) per ogni funzionalità in fase di sviluppo e utilizzare il ramo *master* per l'**integrazione** e per la **consegna finale**.

Per poter effettuare test di unità in mancanza di alcune componenti utilizzare il **mocking** come descritto in seguito.

Una volta che le funzionalità sono state implementate, procedere con il testing esaustivo del programma sviluppato. In questa fase è possibile utilizzare i framework per **code coverage** e **mutation testing**.
Ultimata la fase di *test di unità*, procedere con i *test di integrazione* come descritto in seguito.

Sia durante la fase di *sviluppo*, sia durante la fase di *testing* utilizzare il **bug tracker** per segnalare e tenere traccia di *bug* che causano eventuali malfunzionamenti.


## Strumenti

#### Mocking

Secondo il processo descritto in precedenza, nella parte di test di unità, è possibile effettuare il *mocking* delle componenti esterne in modo da rendere i test indipendenti da eventuali modifiche di esse.

Per effettuare il *mocking* utilizzare la libreria [Mockito](http://mockito.org/) per provvedere ai SUT i *mock*, gli *stub* e gli *spy* opportuni.


#### Coverage

Al fine di stimolare l'esecuzione di ogni componente sviluppata ed evidenziare eventuali malfunzionamenti, i test devono dare luogo ad una *copertura completa* del codice, così come misurata con [Jacoco](http://eclemma.org/jacoco/).

Per ottenere il *report* sulla copertura è sufficiente invocare il
comando
```
./gradlew test jacoco
```
a seguito del quale il report può essere visualizzato aprendo il file `build/reports/jacoco/test/html/index.html`.


#### Mutation

E' possibile inoltre valutare la qualità dei test implementati eseguendo **Mutation testing** attraverso il framework [PIT](http://pitest.org/).
Al fine di ottenere il *report* sul mutation testing è sufficiente invocare il
comando
```
./gradlew pitest
```
a seguito del quale il report può essere visualizzato aprendo il file `index.html` nella directory etichettata con *data* e *ora* corretta sotto `build/reports/pitest/`.

I test di unità integrativi aggiunti in questa fase devono essere inseriti nella directory [mutationTest](/src/mutationTest/java/).

#### Testing funzionale

Al fine di valutare il comportamento dell'intero sistema si suggerisce di effettuare il  *testing funzionale* utilizzando, qualora il programma facesse uso di interfaccia grafica *swing*, la libreria [AssertJ-swing](http://joel-costigliola.github.io/assertj/assertj-swing.html).

Per lanciare i test (che devono essere scritti nella la directory [integrationTest](/src/integrationTest/java/)) utilizzare il comando:

```
./gradlew integrationTest
```

a seguito del quale il report può essere visualizzato aprendo il file `build/reports/integrationTest/index.html`.

#### Issue tracker

L'*issue tracker* del repository Bitbucket deve essere abilitato ed utilizzato per tracciare le anomalie (*bug*) che causano gli eventuali malfunzionamenti individuati durante lo sviluppo del programma.

Utilizzare inoltre l'issue tracker per tracciare le *funzionalità* proposte in fase di *planning*. Quest'ultime devono essere etichettate con tipologia (*Kind*) `proposal` ed opportuna priorità. 

#### Wiki

Utilizzare il [Wiki](https://bitbucket.org/softwareengineeringunimi/progetto_2016-p/wiki/Home) del repository Bitbucket per documentare il lavoro svolto durante la settimana. In particolare, seguendo gli esempi forniti, modificare le seguenti pagine:

* [Planning](https://bitbucket.org/softwareengineeringunimi/progetto_2016-p/wiki/Planning)
* [Scelte progettuali](https://bitbucket.org/softwareengineeringunimi/progetto_2016-p/wiki/Scelte%20progettuali)
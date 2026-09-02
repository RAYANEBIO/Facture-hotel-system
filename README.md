# 🏨 Facture Hotel System

Un système de gestion de facturation pour hôtel développé en **Java**. Ce projet permet de gérer les clients, les chambres, les séjours et la génération automatique des factures.

## 📋 Présentation

Facture Hotel System est une application conçue pour simplifier la gestion administrative d'un hôtel. Elle automatise le calcul des frais liés aux réservations et génère des factures simplement et efficacement.

## ✨ Fonctionnalités

- 👤 Enregistrement et gestion des clients
- 🛏️ Gestion des chambres disponibles
- 📅 Réservation de chambres
- 💰 Calcul automatique du montant du séjour
- 📄 Génération de factures
- 👁️ Affichage des informations clients
- 📊 Historique des réservations
- 💻 Interface en ligne de commande simple et intuitive

## 🛠️ Technologies utilisées

- **Java** (JDK 8+)
- **Programmation Orientée Objet (POO)**
- **Architecture par packages**
- Gestion dynamique des données en mémoire

## 📂 Structure du projet

```
Facture-hotel-system/
│
├── src/
│   └── gestionhotel/
│       └── GestionHotel.java
│
├── build/                  # Fichiers compilés
├── connect/               # Fichiers de connexion
├── nbproject/             # Configuration NetBeans
│
├── build.xml              # Configuration Ant
├── manifest.mf            # Manifest de l'application
├── compteur.txt           # Fichier de suivi
└── README.md
```

## 🚀 Compilation et Exécution

### Avec NetBeans

1. Ouvrez le projet dans NetBeans
2. Cliquez sur **Build Project** ou appuyez sur **F11**
3. Exécutez le projet avec **F6** ou **Run Project**

### Avec javac (ligne de commande)

```bash
# Compilation
javac -d build src/gestionhotel/*.java

# Exécution
java -cp build gestionhotel.GestionHotel
```

### Avec Ant

```bash
# Compilation et exécution
ant run
```

## 💡 Exemple de scénario

1. Création d'un nouveau client
2. Attribution d'une chambre disponible
3. Enregistrement de la réservation
4. Calcul automatique du coût du séjour
5. Génération de la facture
6. Affichage du montant total à payer

### Exemple de sortie

```
╔════════════════════════════════════╗
║   Facture Hotel System             ║
╚════════════════════════════════════╝

=== GESTION HÔTEL ===
Client : Jean Dupont
Numéro de chambre : 205
Nombre de nuits : 4
Prix par nuit : 85 €

Montant total : 340 €
```

## 🎯 Objectifs pédagogiques

Ce projet permet de pratiquer :

- ✅ La programmation orientée objet en Java
- ✅ L'encapsulation des données (getters/setters)
- ✅ Les classes et objets
- ✅ Les constructeurs
- ✅ L'organisation d'un projet logiciel
- ✅ La gestion d'un système de facturation
- ✅ La manipulation de données avec Java

## 🔮 Améliorations futures

- 💾 Sauvegarde des données dans des fichiers (sérialisation)
- 🗄️ Base de données (MySQL, PostgreSQL)
- 🎨 Interface graphique (Swing, JavaFX)
- 👨‍💼 Gestion des employés
- 📊 Statistiques et rapports d'activité
- 📄 Export PDF des factures
- 🔐 Système d'authentification
- 🌐 Service web REST

## 📋 Prérequis

- **JDK 8** ou plus récent
- **NetBeans** (optionnel, ou tout autre IDE Java)
- **Ant** (optionnel, pour la compilation par ligne de commande)

## 👨‍💻 Auteur

**Rayane BIO**

Étudiant en informatique passionné par le développement logiciel, les systèmes de gestion et la programmation orientée objet.

## 📄 Licence

Projet réalisé à des fins pédagogiques et d'apprentissage.

---

**Contribuez !** Si vous avez des suggestions ou des améliorations, n'hésitez pas à ouvrir une issue ou une pull request.
```

(ns reporting-example.models.db
     (:require [clojure.java.jdbc :as sql]))

(def db {:subprotocol "postgresql"
         :subname "//localhost/reporting"
         :user "chrishowe-jones"
         :password ""})

(defn create-employee-table []
  (sql/create-table :employee
                    [:name "varchar(50)"]
                    [:occupation "varchar(50)"]
                    [:place "varchar(50)"]
                    [:country "varchar(50)"]))

;; Uncomment this statement and run it to create and populate the
;; employee table.
(comment sql/with-connection
  db
  (create-employee-table)
  (sql/insert-rows
   :employee
   ["Albert Einstein", "Engineer", "Ulm", "Germany"]
   ["Alfred Hitchcook", "Movie Director", "London", "UK"]
   ["Wernher Von Braun", "Rocket Scientist", "Wyrzysk", "Poland"]
   ["Sigmund Freud", "Neurologist", "Pribor", "Czech Republic"]
   ["Mahatma Gandi", "Lawyer", "Gujarat", "India"]
   ["Sachin Tendulkar", "Cricket Player", "Mumbai", "India"]
   ["Michael Schumacher", "F1 Racer", "Cologne", "Germany"]))

(defn read-employees []
  (sql/with-connection db
    (sql/with-query-results rs
      ["select * from employee"]
      (doall rs))))

(read-employees)

(comment sql/with-connection db
  (sql/drop-table :employee))

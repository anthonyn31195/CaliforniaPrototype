//
//  User.swift
//  CaliforniaPrototype
//
//  Created by Luis Garcia on 2/28/17.
//  Copyright © 2017 HOTB. All rights reserved.
//

import Foundation

public struct User {
    let email : String?
    let name: String?
    let phone: String?
    let address: String?
    let city: String?
    let state: String?
    let zip: String?
    let date: String?
    let locations: [UserLocation]?
    let contacts: [Any]?
    let token: String?
    let id: String?
    let alerts: [Alert]?
    
    static func userFromJson(_ json: [String: Any]) -> User? {
        let userLocation = UserLocation.init(enableSMS: false)
        let alertLocation = Alert.init(name: "")
        var userLocations: [[String: Any]]?
        var alertLocations: [[String: Any]]?
        
        let email = json["email"] as? String
        let name = json["name"] as? String
        let phone = json["phone"] as? String
        let address = json["address"] as? String
        let city = json["city"] as? String
        let state = json["state"] as? String
        let zip = json["zip"] as? String
        let date = json["date"] as? String
        if json["locations"] != nil {
            userLocations = json["locations"] as? [[String: Any]]
        } else {
            userLocations = nil
        }
        let contacts = json["contacts"] as? [Any]
        let token = json["token"] as? String
        let id = json["id"] as? String
        if json["alerts"] != nil {
            alertLocations = json["alerts"] as? [[String: Any]]
        } else {
            alertLocations = nil
        }
        
        
        return User.init(email: email, name: name, phone: phone, address: address, city: city, state: state, zip: zip, date: date, locations: userLocation.locationFromDictionaryArray(userLocations), contacts: contacts, token: token, id: id, alerts: alertLocation.alertArrayFromJsonArray(alertLocations))
    }
}

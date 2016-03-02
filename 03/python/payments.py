with open('payments.dat', 'rb') as f:
    content = f.read().splitlines()

    s1 = content[0]
    s2 = content[1]

    is_reading_name = True
    is_reading_amount = False

    vips = []
    vips.append("rick")
    vips.append("matthew")

    initial_map = {}
    due_map = {}

    current_name = ""
    current_amount = ""

    for c in s1:
        if is_reading_name == True:
            if c == ':':
                # Name is read
                is_reading_name = False
                is_reading_amount = True
            else:
                current_name = current_name + c
        elif is_reading_amount == True:
            if c == '|':
                # Amount read
                is_reading_name = True
                is_reading_amount = False
                initial_map[current_name] = int(current_amount)
                due_map[current_name] = int(current_amount)
                current_amount = ""
                current_name = ""
            else:
                current_amount = current_amount + c

    for c in s2:
        if is_reading_name == True:
            if c == ':':
                # Amount is read
                is_reading_name = False
                is_reading_amount = True
            else:
                current_name = current_name + c
        elif is_reading_amount == True:
            if c == '|':
                # Name read
                is_reading_name = True
                is_reading_amount = False
                due_map[current_name] = due_map[current_name] - int(current_amount)
                current_amount = ""
                current_name = ""
            else:
                current_amount = current_amount + c

    due_map2 = dict(due_map)

    for name in due_map2:
        due = due_map[name]

        # VIPs be VIPs :)
        if due == 0 or name in due_map and due * 100 / initial_map[name] <= 10:
            del due_map[name]

    for s in due_map:
        print s + " : " + str(due_map[s])


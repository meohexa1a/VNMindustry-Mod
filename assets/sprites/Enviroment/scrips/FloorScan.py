import os
import shutil
import re
from collections import defaultdict

directory = 'C:/Users/asv/project/VNMindustry-Mod/assets/Enviroment/Floor'
pattern = re.compile(r'(\w+[-\w]+[-\w]*)(\d+)\.png')

file_groups = defaultdict(list)

for filename in os.listdir(directory):
    match = pattern.match(filename)
    if match:
        base_name, variant = match.groups()
        file_groups[base_name].append((filename, variant))

for idx, (base_name, files) in enumerate(file_groups.items()):
    new_folder_name = f"{idx}_{base_name}"
    new_folder_path = os.path.join(directory, new_folder_name)
    
    if not os.path.exists(new_folder_path):
        os.makedirs(new_folder_path)
    
    for file_name, variant in files:
        old_file_path = os.path.join(directory, file_name)
        new_file_name = f"{idx}{variant}.png"
        new_file_path = os.path.join(new_folder_path, new_file_name)
        
        shutil.move(old_file_path, new_file_path)
        print(f"Đã di chuyển {file_name} thành {new_file_path}")

print("Xử lý hoàn tất.")
